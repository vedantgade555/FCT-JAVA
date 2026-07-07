import React, { useState } from 'react';
import { supabase } from '../supabaseClient';
import { Container, Form, Button, Alert, Card } from 'react-bootstrap';

export default function Auth() {
  const [loading, setLoading] = useState(false);
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState({ type: '', content: '' });

  const handleSignUp = async (e) => {
    e.preventDefault();
    setLoading(true);
    const { error } = await supabase.auth.signUp({ email, password });
    if (error) {
      setMessage({ type: 'danger', content: error.message });
    } else {
      setMessage({ type: 'success', content: 'Check your email for the login link!' });
    }
    setLoading(false);
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    setLoading(true);
    const { error } = await supabase.auth.signInWithPassword({ email, password });
    if (error) {
      setMessage({ type: 'danger', content: error.message });
    } else {
      setMessage({ type: 'success', content: 'Logged in successfully!' });
    }
    setLoading(false);
  };

  return (
    <Container className="d-flex align-items-center justify-content-center" style={{ minHeight: "100vh" }}>
      <div className="w-100" style={{ maxWidth: "400px" }}>
        <Card className="shadow-sm">
          <Card.Body>
            <h2 className="text-center mb-4">Supabase + Spring Boot App</h2>
            {message.content && <Alert variant={message.type}>{message.content}</Alert>}
            <Form>
              <Form.Group id="email" className="mb-3">
                <Form.Label>Email</Form.Label>
                <Form.Control type="email" required value={email} onChange={(e) => setEmail(e.target.value)} />
              </Form.Group>
              <Form.Group id="password" className="mb-4">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" required value={password} onChange={(e) => setPassword(e.target.value)} />
              </Form.Group>
              <Button disabled={loading} className="w-100 mb-2 btn-primary" type="button" onClick={handleLogin}>
                Log In
              </Button>
              <Button disabled={loading} className="w-100 btn-outline-secondary" variant="outline-secondary" type="button" onClick={handleSignUp}>
                Sign Up
              </Button>
            </Form>
          </Card.Body>
        </Card>
      </div>
    </Container>
  );
}
