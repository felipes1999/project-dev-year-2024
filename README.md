# Java API restful

diagramas de classes

 ```mermaid
   erDiagram
    USUARIO {
        int id_usuario PK
        string nome
        string email
        string senha
        string telefone
    }
    
    AGENDAMENTO {
        int id_agendamento PK
        int id_usuario FK
        datetime data_hora_inicio
        datetime data_hora_fim
    }
    
    USUARIO ||--o{ AGENDAMENTO : "realiza"
 ```
