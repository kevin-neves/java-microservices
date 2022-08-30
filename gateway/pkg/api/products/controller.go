package products

import (
	"net/http"
	"net/http/httputil"
	"net/url"
	"os"

	"github.com/gin-gonic/gin"
)

var productsAdd string = os.Getenv("PRODUCTS_ADDR") //"http://localhost:8082/products"

func ProductProxy(c *gin.Context) {
	remote, err := url.Parse(productsAdd)
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
