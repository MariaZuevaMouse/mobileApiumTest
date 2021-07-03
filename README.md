# mobileAppiumTest



How to start cloud tests:

1. Paste api-token in pom.xml (root directory) in section 'properties' tag 'token'
3. Start tests:

  
  - iOS native  
  
  `mvn test -P native_ios_cloud`
  - iOS web
  
  `mvn test -P web_ios_cloud`
  
  - android web
  
  `mvn test -P web_android_cloud`
  
   - android native  
  
  `mvn test -P native_android_cloud`
