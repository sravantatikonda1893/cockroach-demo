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

