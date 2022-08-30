package customers

import (
	"net/http"
	"net/http/httputil"
	"net/url"
	"os"

	"github.com/gin-gonic/gin"
)

var customersAddr string = os.Getenv("CUSTOMERS_ADDR") //"http://localhost:8083/customers"

func CustomerProxy(c *gin.Context) {
	remote, err := url.Parse(customersAddr)
	if err != nil {
		panic(err)
	}

	proxy := httputil.NewSingleHostReverseProxy(remote)

	proxy.Director = func(req *http.Request) {
		req.Header = c.Request.Header
		req.Host = remote.Host
		req.URL.Scheme = remote.Scheme
		req.URL.Host = remote.Host
		req.URL.Path = remote.Path + c.Param("params")
	}

	proxy.ServeHTTP(c.Writer, c.Request)
}
