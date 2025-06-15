import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async () => {
    try {
      const res = await axios.post('http://localhost:8080/api/v1/auth/login', { username, password });
      localStorage.setItem('token', res.data);
      navigate('/dashboard');
    } catch (err) {
      alert('Credenciais inválidas');
    }
  };

  return (
    <div style={{ padding: 20 }}>
      <h2>Login</h2>
      <input value={username} onChange={e => setUsername(e.target.value)} placeholder="Usuário" /><br />
      <input type="password" value={password} onChange={e => setPassword(e.target.value)} placeholder="Senha" /><br />
      <button onClick={handleLogin}>Entrar</button>
    </div>
  );
}
