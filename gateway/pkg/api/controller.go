package api

import (
	"github.com/gin-gonic/gin"
	"github.com/kevin-neves/java-microservices/gateway/pkg/api/customers"
	"github.com/kevin-neves/java-microservices/gateway/pkg/api/products"
	"github.com/kevin-neves/java-microservices/gateway/pkg/api/shopCart"
)

func RegisterRoutes(r *gin.Engine) {
	r.Any("/customers/*params", customers.CustomerProxy)
	r.Any("/products/*params", products.ProductProxy)
	r.Any("/shop-cart/*params", shopCart.ShopCartProxy)
}
