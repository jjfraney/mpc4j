#Invoking Commands

```java
    // to set volume to 10%
    final SetVol setVol = new SetVol(10);
    final Simple.Response setVolResponse = .....send(setVol);
    final boolean success = setVolResponse.isOk();
    
    final Status status = new Status();
    final Status.Response statusResponse = ....send(status);
    final Integer volume = statusResponse.getVolume().orElseThrow(RuntimeException::new);

```
