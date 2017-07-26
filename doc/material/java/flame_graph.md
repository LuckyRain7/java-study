``` 
java Main -XX:+PreserveFramePointer

JAVA_PROCESS_ID=$1

sudo perf record -F 99 -a -g -- sleep 30

java -cp attach-main.jar:$JAVA_HOME/lib/tools.jar net.virtualvoid.perf.AttachOnce $JAVA_PROCESS_ID

sudo chown root /tmp/perf-*.map

sudo perf script | stackcollapse-perf.pl | flamegraph.pl --color=java --hash > flamegraph.svg

```