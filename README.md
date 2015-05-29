#Poseidon

#[Documentation](edenzik.github.io/Poseidon/doc/index.html)

## Introduction
Poseidon is a library and simply demo application put together by four students at Brandeis University with guidance from Streambase, a subsidiary of Tibco inc.

Streambase makes a live stream database allowing users to manipulate high velocity data in real time. We attempted to augment their vision for the product with our own, which we call Poseidon. 

The Streambase system is built for performance. In designing Poseidon, we made several compromises related to speed in favor of universal compatibility with streaming sources as well as intuition for the user. 

There are several novel aspects about this system, which will be outlined below. This project was implemented using the Vaadin web framework in Java, with hopefully enough modularity to enable most to pick up at least most of the internals and play with them.

##Idea

When setting out to design this system, we had to step back and consider what the most average use case of streaming data is. Our first thought, which guided us throughout this project, was Twitter - a source of continuous live data that might reflect the current state of what people are thinking. Twitter, like many other API's, is so called "RESTful" - as it provides a response to HTTP GET and POST requests which can be issued from clients - be other web applications or various
Twitter front ends.

The beauty of a RESTful API is that all requests to all services on the web are fairly similar, with only the endpoints and the manner of authentication varying. In addition (although not a requirement) the response to RESTful API requests is mostly given in a JSON format, which makes it even easier to work with.

So we thought a novel take on a Streaming system is to make it wholly based on JSON, and hence be able to receive information from any source implementing a REST API (of which there are many).

Combined with real time streaming data manipulation, the system should be able to be intuitive and versatile enough to handle a variety of scenarios - and give users the power to query real time feeds. 

##Model

The model of Poseidon is inspired by finite automata, in which each discrete "node" represents a unit of computation, which holds a certain amount of data and when done it forwards it to downstream nodes. 

In this manner, one can think of this system as a directed graph in which there are no cycles with arbitrary fanout (similar to a Trie structure or a DFA).

Each "state" in the graph is called an operator, and it is solely resp

Ther are several main ideas behind Poseidon:

- The ability to process JSON format as input in real time.
- The ability to see design a real time graph reflecting the state of the data at any given point
- The ability to connect any node to any other downstream node, and hence move data around independently of any restrictions.


Basic architecture of Operators:
Every operator has its own buffer for receiving data from other operators(except for In). The only job for the operator is reading json objects from its buffer, processing the data and sending to next operators' buffers. So with this structure, operators can connect to operators as many as they need without limitations.

The limitation is that the overall speed will be slowed down by the slowest operators, such as join. And we also need to consider the possibility of losing data since if there's no connected operators, then the data just flow away.

How operator runs
Every operator runs as an independent thread, and it runs automatically as soon as it being created.

The problem with Join and its solution Join operator takes two json objects that comes from two different input sources, and merges them into one json object based on keys. One problem of Join is that since all the output of its previous operators are put into the same buffer of join, it is possible that the Join operator picks up two jsons that come from the same input source.
The solution is that we made a JSONObject class inherited from Java's json object class, and we tag all JSONObjects with the hashcode of the operator they passed by. So when Join operator picks up two jsons with different tags, it shows that they come from different sources.

Filter accepts regular expression, which accepts all possible patterns that users need.

##Building
To build Poseidon, execute `mvn build`, which will download all the necessary dependencies.

##Running

To run Poseidon, run `mvn jetty:run`, which will host it on port 8080 locally. 
