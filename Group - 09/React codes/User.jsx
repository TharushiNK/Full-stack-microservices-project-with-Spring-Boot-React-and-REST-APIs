import React, { useState } from 'react';
import { Box, TextField, Container, Button } from '@mui/material';
import { useNavigate } from 'react-router-dom';

export default function User() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [message, setMessage] = useState('');
  const [messageType, setMessageType] = useState('');
  const navigate = useNavigate();

  const handleClick = async (e) => {
    e.preventDefault();
    const user = { email, password };

    try {
      const response = await fetch("http://localhost:8081/go-rentals/users/login", {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(user),
      });

      const data = await response.json();

      if (response.ok) {
        setMessage(data.message || 'Login Successful');
        setMessageType('success');

        setTimeout(() => {
          navigate('/CarList'); 
        }, 1000);
      } else {
        setMessage(data.message || 'Invalid email or password');
        setMessageType('error');
      }
    } catch (error) {
      console.error('Error:', error);
      setMessage('Login Failed');
      setMessageType('error');
    }
  };

  return (
    <Container>
      <Box component="form" sx={{ '& > :not(style)': { m: 1, width: '25ch' } }} noValidate autoComplete="off">
        <h1 style={{ color: 'blue' }}><u>Login</u></h1>

        <TextField
          id="email"
          label="EMAIL"
          variant="outlined"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <TextField
          id="password"
          label="PASSWORD"
          variant="outlined"
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </Box>
      <Button variant="contained" onClick={handleClick}>LOGIN</Button>

      {message && (
        <h2 style={{ color: messageType === 'success' ? 'green' : 'red' }}>{message}</h2>
      )}
    </Container>
  );
}
