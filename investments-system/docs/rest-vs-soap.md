# Comparação entre REST e SOAP

| Característica        | REST                                 | SOAP                                 |
|------------------------|--------------------------------------|--------------------------------------|
| Protocolo              | HTTP puro                            | Protocolo próprio sobre HTTP         |
| Formato de Dados       | JSON (geralmente), XML               | XML                                   |
| Performance            | Leve, rápido                         | Mais pesado devido a XML e headers   |
| Facilidade de uso      | Simples, direto                      | Mais complexo, baseado em contrato   |
| Padrão                 | Arquitetural (sem regras fixas)      | Estritamente padronizado (WSDL)      |
| Verbo HTTP             | Usa GET, POST, PUT, DELETE, PATCH    | Normalmente POST                     |
| Segurança              | HTTPS + JWT                          | WS-Security                          |
| Exemplo de uso         | APIs web modernas                    | Sistemas bancários e legados         |

REST é mais usado para aplicações web e mobile modernas.  
SOAP é ideal quando há necessidade de padrão, contrato formal, e robustez em segurança/transações.
