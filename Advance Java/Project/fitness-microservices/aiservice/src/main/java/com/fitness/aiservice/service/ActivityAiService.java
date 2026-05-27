package com.fitness.aiservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitness.aiservice.model.Activity;
import com.fitness.aiservice.model.Recommendations;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityAiService {

    private final GeminiService geminiService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Recommendations generateRecommendation(Activity activity) {

        String prompt = createPromptForActivity(activity);

        try {
            String aiResponse = geminiService.getAnswer(prompt);

            log.info("AI RESPONSE : {}", aiResponse);

            return processAiResponse(activity, aiResponse);

        } catch (Exception e) {

            log.error("Error while generating recommendation", e);

            return createDefaultRecommendation(activity);
        }
    }

    private Recommendations processAiResponse(Activity activity, String aiResponse) {

        try {

            // Convert AI response to Json
            JsonNode rootNode = objectMapper.readTree(aiResponse);

            // Get text from Gemini response
            String responseText = rootNode
                    .path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text")
                    .asText();

            // Remove ```json and ```
            responseText = responseText
                    .replace("```json", "")
                    .replace("```", "")
                    .trim();

            log.info("PARSED RESPONSE : {}", responseText);

            // Convert cleaned text to Json
            JsonNode json = objectMapper.readTree(responseText);

            // Get analysis section
            JsonNode analysis = json.path("analysis");

            String recommendation =
                    "Overall: " + analysis.path("overall").asText() + "\n\n" +
                            "Pace: " + analysis.path("pace").asText() + "\n\n" +
                            "Heart Rate: " + analysis.path("heartRate").asText() + "\n\n" +
                            "Calories: " + analysis.path("caloriesBurned").asText();

            return Recommendations.builder()
                    .activityId(activity.getId())
                    .userId(activity.getUserId())
                    .activityType(activity.getType())
                    .recommendation(recommendation)
                    .improvements(getImprovements(json.path("improvements")))
                    .suggestions(getSuggestions(json.path("suggestions")))
                    .safety(getSafety(json.path("safety")))
                    .createdAt(LocalDateTime.now())
                    .build();

        } catch (Exception e) {

            log.error("Error while parsing AI response", e);

            return createDefaultRecommendation(activity);
        }
    }

    private List<String> getImprovements(JsonNode improvementsNode) {

        List<String> list = new ArrayList<>();

        if (improvementsNode.isArray()) {

            for (JsonNode item : improvementsNode) {

                String area = item.path("area").asText();

                String recommendation = item.path("recommendation").asText();

                list.add(area + ": " + recommendation);
            }
        }

        if (list.isEmpty()) {
            return Collections.singletonList("No specific improvements provided");
        }

        return list;
    }

    private List<String> getSuggestions(JsonNode suggestionsNode) {

        List<String> list = new ArrayList<>();

        if (suggestionsNode.isArray()) {

            for (JsonNode item : suggestionsNode) {

                String workout = item.path("workout").asText();

                String description = item.path("description").asText();

                list.add(workout + ": " + description);
            }
        }

        if (list.isEmpty()) {
            return Collections.singletonList("No specific suggestions provided");
        }

        return list;
    }

    private List<String> getSafety(JsonNode safetyNode) {

        List<String> list = new ArrayList<>();

        if (safetyNode.isArray()) {

            for (JsonNode item : safetyNode) {

                list.add(item.asText());
            }
        }

        if (list.isEmpty()) {
            return Collections.singletonList("No safety guidelines provided");
        }

        return list;
    }

    private Recommendations createDefaultRecommendation(Activity activity) {

        return Recommendations.builder()
                .activityId(activity.getId())
                .userId(activity.getUserId())
                .activityType(activity.getType())
                .recommendation("Unable to generate analysis at this time.")
                .improvements(
                        Collections.singletonList("Continue with current routine.")
                )
                .suggestions(
                        Collections.singletonList("Maintain current workout frequency.")
                )
                .safety(
                        Collections.singletonList("Observe standard safety guidelines.")
                )
                .createdAt(LocalDateTime.now())
                .build();
    }

    private String createPromptForActivity(Activity activity) {
        return String.format("""
        Analyze this fitness activity and provide detailed recommendations in the following EXACT JSON format:
        {
          "analysis": {
            "overall": "Overall analysis here",
            "pace": "Pace analysis here",
            "heartRate": "Heart rate analysis here",
            "caloriesBurned": "Calories analysis here"
          },
          "improvements": [
            {
              "area": "Area name",
              "recommendation": "Detailed recommendation"
            }
          ],
          "suggestions": [
            {
              "workout": "Workout name",
              "description": "Detailed workout description"
            }
          ],
          "safety": [
            "Safety point 1",
            "Safety point 2"
          ]
        }

        Analyze this activity:
        Activity Type: %s
        Duration: %d minutes
        Calories Burned: %d
        Additional Metrics: %s
        
        Provide detailed analysis focusing on performance, improvements, next workout suggestions, and safety guidelines.
        Ensure the response follows the EXACT JSON format shown above.
        """,
                activity.getType(),
                activity.getDuration(),
                activity.getCaloriesBurned(),
                activity.getAdditionalMetrics()
        );
    }
}