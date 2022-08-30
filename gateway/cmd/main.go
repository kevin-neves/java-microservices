package main

import (
	"github.com/gin-gonic/gin"

	"github.com/kevin-neves/java-microservices/gateway/pkg/api"
)

const port string = ":8080"

func main() {
	r := gin.Default()

	api.RegisterRoutes(r)

	r.Run(port)
}
