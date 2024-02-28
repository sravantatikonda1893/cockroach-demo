CockroachDB is a distributed SQL database built on top of a transactional and consistent key-value store.

Written in Go and completely open source, its primary design goals are the support for ACID transactions, horizontal scalability, and survivability.

CockroachDB can be considered a well-suited solution for applications that require reliable, available, and correct data regardless of scale.

key aspects of CockroachDB:

SQL API and PostgreSQL compatibility – for structuring, manipulating and querying data

ACID transactions – supporting distributed transactions and provides strong consistency

Cloud-ready – designed to run in the cloud or on an on-premises solution providing easy migration between different cloud providers without any service interruption

Scales horizontally – adding capacity is as easy as pointing a new node at the running cluster with minimal operator overhead

Replication – replicates data for availability and guarantees consistency between replicas

Automated repair – continue seamlessly as long as a majority of replicas remain available for short-term failures while, for longer-term failures, automatically rebalances replicas from the missing nodes, using the unaffected replicas as sources

Install:
brew update
brew install cockroachdb/tap/cockroach

# Demo Project for Spring Boot with Cockroach

Running a secure cluster:

cockroach start --certs-dir=certs --store=node1 --listen-addr=localhost:26257 --http-addr=localhost:8080 --join=localhost:26257,localhost:26258,localhost:26259

cockroach start  --certs-dir=certs  --store=node2  --listen-addr=localhost:26258 --http-addr=localhost:8081 --join=localhost:26257,localhost:26258,localhost:26259

cockroach start  --certs-dir=certs --store=node3  --listen-addr=localhost:26259 --http-addr=localhost:8082 --join=localhost:26257,localhost:26258,localhost:26259

Check status:
grep 'node starting' node1/logs/cockroach.log -A 11

cockroach sql --certs-dir=certs --host=localhost:26257

CREATE DATABASE cockroachdemo;

CREATE USER sravan WITH PASSWORD 'roach';

GRANT admin TO sravan;

ps -ef | grep cockroach | grep -v grep
kill -TERM {PID}

Login to Cockroach console with username/password created through SQL console:
    https://localhost:8080/#/overview/list

