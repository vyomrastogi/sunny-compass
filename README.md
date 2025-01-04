# Sunny Compass

Sunny Compass is a personal project. 
It is starting as a modular monolith web application designed to simplify managing daily household activities. 

## Technology Stack

### Backend
- **Language**: Java
- **Framework**: Spring Boot
- **Database**: NoSQL datastore (TBD)
- **Design Patterns**: 
  - Command/Query Responsibility Segregation (CQRS) _hopefully_

## Getting Started

### Example API Usage
#### Create a Category

```http
POST http://localhost:8080/api/v1/categories/ HTTP/1.1
Content-Type: application/json

{
    "name":"Entertainment",
    "type":"SINK",
    "tags":[
        "flex"
    ]
}
```

## Roadmap

_tba_

---

Happy sailing with Sunny Compass! 🌞

