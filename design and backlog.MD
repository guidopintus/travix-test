Here follows a brief description of the modules, the shortcomings and the next tasks.

## BusyFlightsController 
  
takes the request and forwards it to the SearchFlightsAction module. Exceptions are handled through a @ControllerAdvice annotated class.
   
  
**There is the need  to define how the application should notify internal server errors
and partial failures regarding specific supplier services. My current plan
would be a partial list of flights, and (if the end user is not the public) a list of failing supplier services.**

## SearchFlightsAction 
  
Takes the BusyFlightsRequest object and from it builds the BusyFlightResponse object. More specifically, it's implementation 
validates the request content, obtains the list of flights and builds a response object. It makes use of 3 modules that perform these tasks:
RequestValidator, ResponseBuilder and AggregatorFlightFinder
  

**Currently there is not an implementation of RequestValidator, and responseBuilder implementation doesn't handle exceptions,
due to time constraints.**
  
## AggregatorFlightFinder
  
It makes use of all extensions of the abstract class AbstractSupplierFlightFinder and aggregates the results in a single list.
  
  
## AbstractSupplierFlightFinder
  
Makes use of 3 modules, injected by extensions of this class:
  
- SupplierRequestAdapter
- SupplierClient 
- SupplierResponseAdapter


**There is a lack of unit tests and exception handling regarding the flight aggregator, the AbstractSupplierFlightFinder
and the supplier implementations, again because of time constraint, so my main focus would go toward those tasks.**
