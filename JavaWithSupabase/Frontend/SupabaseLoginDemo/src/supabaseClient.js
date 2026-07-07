import { createClient } from '@supabase/supabase-js';

// TODO: Replace these with your actual Supabase URL and Anon Key
const supabaseUrl = 'https://ewkjdqmtqypgmfbonnqg.supabase.co';
const supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImV3a2pkcW10cXlwZ21mYm9ubnFnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3ODM0MzY3MzAsImV4cCI6MjA5OTAxMjczMH0.aCGvKBQo5BVYzHmXjIjMG5nn0ZTWY9pRRdWRjSnCWdA';

export const supabase = createClient(supabaseUrl, supabaseKey);
