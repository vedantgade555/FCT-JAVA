import { createClient } from '@supabase/supabase-js';

const supabaseUrl = 'https://ewkjdqmtoypgmfbonnqg.supabase.co';
const supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImV3a2pkcW10cXlwZ21mYm9ubnFnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3ODM0MzY3MzAsImV4cCI6MjA5OTAxMjczMH0.aCGvKBQo5BVYzHmXjIjMG5nn0ZTWY9pRRdWRjSnCWdA';

const supabase = createClient(supabaseUrl, supabaseKey);

async function testSignUp() {
  const { data, error } = await supabase.auth.signUp({
    email: 'test' + Date.now() + '@example.com',
    password: 'password123'
  });
  console.log("Data:", data);
  console.log("Error:", error);
}

testSignUp();
