#Poseidon


Basic architecture of Operators:
Every operator has its own buffer for receiving data from other operators(except for In). The only job for the operator is reading json objects from its buffer, processing the data and sending to next operators' buffers. So with this structure, operators can connect to operators as many as they need without limitations.

The limitation is that the overall speed will be slowed down by the slowest operators, such as join. And we also need to consider the possibility of losing data since if there's no connected operators, then the data just flow away.

How operator runs
Every operator runs as an independent thread, and it runs automatically as soon as it being created.

The problem with Join and its solution Join operator takes two json objects that comes from two different input sources, and merges them into one json object based on keys. One problem of Join is that since all the output of its previous operators are put into the same buffer of join, it is possible that the Join operator picks up two jsons that come from the same input source.
The solution is that we made a JSONObject class inherited from Java's json object class, and we tag all JSONObjects with the hashcode of the operator they passed by. So when Join operator picks up two jsons with different tags, it shows that they come from different sources.

Filter accepts regular expression, which accepts all possible patterns that users need.
