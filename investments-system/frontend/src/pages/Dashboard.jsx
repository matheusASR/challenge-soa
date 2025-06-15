import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function Dashboard() {
  const [recommendation, setRecommendation] = useState('');

  useEffect(() => {
    const fetchData = async () => {
      try {
        const token = localStorage.getItem('token');
        const res = await axios.get('http://localhost:8080/api/v1/recommendations/conservative', {
          headers: {
            Authorization: `Bearer ${token}`
          }
        });
        setRecommendation(res.data);
      } catch (err) {
        alert('Erro ao carregar recomendações');
      }
    };
    fetchData();
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h2>Bem-vindo!</h2>
      <p>Sua recomendação: {recommendation}</p>
    </div>
  );
}
