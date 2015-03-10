# 3ptimer
Productivity, Pairing, Pause Timer

# Why another app?
Currently I use [Minutes](https://www.google.de/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0CC8QFjAA&url=https%3A%2F%2Fitunes.apple.com%2Fde%2Fapp%2Fminutes-app%2Fid547097299%3Fmt%3D8&ei=aJb5VI2wO4HFUqzSg-gP&usg=AFQjCNFUUNyOvGt40vwcSw-BfFT5PJCGvg&sig2=gx5SMZHuVkPxJWJ6C-cewg&bvm=bv.87611401,d.d24) for [pair programming](http://en.wikipedia.org/wiki/Pair_programming) and [Healthier](https://www.google.de/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&uact=8&ved=0CDsQFjAB&url=https%3A%2F%2Fitunes.apple.com%2Fde%2Fapp%2Fhealthier-break-reminder%2Fid534953542%3Fmt%3D12&ei=p5b5VM-YD8PuUujlgPAO&usg=AFQjCNFRACtHJcOmztAI8DheIjxsg34kLw&sig2=025VF9HgUHGYdV2Cqseo6g&bvm=bv.87611401,d.d24) for pauses.
However I saw the two timers diverge, so I wanted the functionality in one app.

Developer Warning: This is not the TTD approach right now. It's the [Worse Is Better](http://en.wikipedia.org/wiki/Worse_is_better).

# How to start the app without params:

```
java -jar ppptimer-1.0-SNAPSHOT.jar
```

# How to start the app with params:

```
java -jar ppptimer-1.0-SNAPSHOT.jar 600 300 4 5
```

1st arg: Pairing session duration in seconds (10 Minutes)

2nd arg: Pause duration in seconds (5 Minutes)

3rd arg: How many pairing sessions before pause? (after 40 minutes)

4th arg: How many pairing sessions at all? (5)
