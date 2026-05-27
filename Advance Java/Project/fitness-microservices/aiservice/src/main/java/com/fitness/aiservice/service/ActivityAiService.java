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

    public Recommendations generateRecommendation(Activity activity) {
        String prompt = createPromptForActivity(activity);
        try {
            String aiResponse = geminiService.getAnswer(prompt);
            log.info("RESPONSE FROM AI: {} ", aiResponse);
            return processAiResponse(activity, aiResponse);
        } catch (Exception e) {
            log.error("Failed to generate AI recommendation", e);
            return createDefaultRecommendation(activity);
        }
    }

    private Recommendations processAiResponse(Activity activity, String aiResponse) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(aiResponse);

            JsonNode textNode = rootNode.path("candidates")
                    .get(0)
                    .path("content")
                    .path("parts")
                    .get(0)
                    .path("text");

            String jsonContent = textNode.asText()
                    .replaceAll("```json\\n", "")
                    .replaceAll("\\n```", "")
                    .trim();

            log.info("PARSE RESPONSE FROM AI: {} ", jsonContent);

            JsonNode analysisJson = mapper.readTree(jsonContent);
            JsonNode analysisNode = analysisJson.path("analysis");

            StringBuilder fullAnalysis = new StringBuilder();
            addAnalysisSection(fullAnalysis, analysisNode, "overall", "Overall: ");
            addAnalysisSection(fullAnalysis, analysisNode, "pace", "Pace: ");
            addAnalysisSection(fullAnalysis, analysisNode, "heartRate", "Heart Rate: ");
            addAnalysisSection(fullAnalysis, analysisNode, "caloriesBurned", "Calories: ");

            List<String> improvements = extractImprovements(analysisJson.path("improvements"));
            List<String> suggestions = extractSuggestion(analysisJson.path("suggestions"));
            List<String> safety = extractSafetyGuidelines(analysisJson.path("safety"));

            return Recommendations.builder()
                    .activityId(activity.getId())
                    .userId(activity.getUserId())
                    .activityType(activity.getType())
                    .recommendation(fullAnalysis.toString().trim())
                    .improvements(improvements)
                    .suggestions(suggestions)
                    .safety(safety)
                    .createdAt(LocalDateTime.now())
                    .build();
        } catch (Exception e) {
            log.error("Failed to parse AI response", e);
            return createDefaultRecommendation(activity);
        }
    }

    private Recommendations createDefaultRecommendation(Activity activity) {
        return Recommendations.builder()
                .activityId(activity.getId())
                .userId(activity.getUserId())
                .activityType(activity.getType())
                .recommendation("Unable to generate analysis at this time.")
                .improvements(Collections.singletonList("Continue with current routine."))
                // FIXED: Replaced undefined variable with a default singleton list
                .suggestions(Collections.singletonList("Maintain current workout frequency."))
                // FIXED: Better default handling for safety list
                .safety(Collections.singletonList("Observe standard safety guidelines."))
                .createdAt(LocalDateTime.now())
                .build();
    }

    private List<String> extractSafetyGuidelines(JsonNode safetyNode) {
        List<String> safety = new ArrayList<>();
        if (safetyNode.isArray()) {
            for (JsonNode point : safetyNode) {
                safety.add(point.asText());
            }
        }
        return safety.isEmpty() ? Collections.singletonList("No specific safety guidelines provided") : safety;
    }

    private List<String> extractSuggestion(JsonNode suggestionsNode) {
        List<String> suggestionsList = new ArrayList<>();
        if (suggestionsNode.isArray()) {
            for (JsonNode suggestion : suggestionsNode) {
                String workout = suggestion.path("workout").asText();
                String description = suggestion.has("description") ?
                        suggestion.path("description").asText() : "No description provided";

                suggestionsList.add(String.format("%s: %s", workout, description));
            }
        }
        return suggestionsList.isEmpty() ? Collections.singletonList("No specific suggestions provided") : suggestionsList;
    }

    private List<String> extractImprovements(JsonNode improvementsNode) {
        List<String> improvementsList = new ArrayList<>();
        if (improvementsNode.isArray()) {
            for (JsonNode improvement : improvementsNode) {
                String area = improvement.path("area").asText();
                String detail = improvement.has("recommendation") ?
                        improvement.path("recommendation").asText() : "No detailed recommendation";

                improvementsList.add(String.format("%s: %s", area, detail));
            }
        }
        return improvementsList.isEmpty() ? Collections.singletonList("No specific improvements provided") : improvementsList;
    }

    private void addAnalysisSection(StringBuilder fullAnalysis, JsonNode analysisNode, String key, String prefix) {
        if (!analysisNode.path(key).isMissingNode() && !analysisNode.path(key).asText().isEmpty()) {
            fullAnalysis.append(prefix)
                    .append(analysisNode.path(key).asText())
                    .append("\n\n");
        }
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