# Takeout_Ordering_Web_Application
a takeout food ordering system based on Spring Cloud , which allows user to order takeout, admin to process customer orders, handle menu information and mange users information.

##application structure
eureka server
config server
eureka client:consume the following four microservice
account, menu, order, user----four microservice registered with eureka server
