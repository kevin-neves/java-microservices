FROM golang:1.19-alpine AS build_base

RUN apk add --no-cache git
RUN apk add --update make

WORKDIR /tmp/go-gateway

COPY go.mod .
COPY go.sum .

RUN go mod download

COPY . .

RUN make build

# Create a new fresh image, and optmize the size of the application
FROM alpine:3.9
RUN apk add ca-certificates

COPY --from=build_base /tmp/go-gateway/out/go-gateway /app/go-gateway

EXPOSE 8080

CMD ["./app/go-gateway"]