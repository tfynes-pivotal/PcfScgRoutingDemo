# PcfScgRoutingDemo

HelloInternal as internal 'hello world' rest endpoint
listens on 
	/ 	outputs 'hello internal'
	/foo	outputs 'hello internal foo'


HelloExternal as 'external' hello-world rest endpoint
listens on
	/search 	outputs 'hello external search'
	/search/foo	outputs 'hello external search foo'


HelloFacde is SpringCloudGateway driven facade that routes calls to HelloInternal by default unless the top level context is /search

Note - URLs are not being rewritten at this point.


DEMO:

browse to https://hellointernal.<domain>/		observe 'hello internal'
browse to https://hellointernal.<domain>/foo		observe 'hello internal foo'

browse to https://helloexternal.<domain>/search		observe 'hello external search'
browse to https://helloexternal.<domain>/search/foo	observe 'hello external search foo'

NOW SHOW HOW BOTH HELLOINTERNAL AND HELLOEXTERNAL ARE ACCESSIBLE VIA A SINGLE FACADE HOSTNAME

browse to https://hellofacade.<domain>/ 		observe 'hello internal'
browse to https://hellofacade.<domain>/			observe 'hello internal foo'

browse to https://hellofacade.<domain>/			observe 'hello external search'
browse to https://hellofacade.<domain>/			observe 'hello external search foo'
	

CONFIGURATION OF HELLOFACADE / SPRING CLOUD GATEWAY
		/src/main/resources/application.yml

spring:
  cloud:
    gateway:
      routes:
      - id: external
        uri: https://helloexternal.homelab.fynesy.com
        predicates:
        - Path=/search/**
        
      - id: default
        uri: https://hellointernal.homelab.fynesy.com
        predicates:
        - Path=/**
