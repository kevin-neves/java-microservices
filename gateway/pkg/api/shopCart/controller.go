package shopCart

import (
	"net/http"
	"net/http/httputil"
	"net/url"
	"os"

	"github.com/gin-gonic/gin"
)

var shopCartAdd string = os.Getenv("SHOP_CART_ADDR") //"http://localhost:8081/shop-cart"

func ShopCartProxy(c *gin.Context) {
	remote, err := url.Parse(shopCartAdd)
	if err != nil {
		panic(err)
	}

	proxy := httputil.NewSingleHostReverseProxy(remote)

	proxy.Director = func(req *http.Request) {
		req.Header = c.Request.Header
		req.Host = remote.Host
		req.URL.Scheme = remote.Scheme
		req.URL.Host = remote.Host
		req.URL.Path = c.Param("params")
	}

	proxy.ServeHTTP(c.Writer, c.Request)
}
