# thread-concepts

1. CommonPoolTest -  ForkJoinPool and commonPool. When not to use common pool.
     `ref` : https://dzone.com/articles/be-aware-of-forkjoinpoolcommonpool
     
    `Build the image:`
     docker build -t demo100 .

   `Run with 3 cpu:`
    docker run --cpus 3 demo100

   `Run with 1 cpu:`
    docker run --cpus 1 demo100

     
