#!/bin/sh

source /etc/profile;
BASEDIR=`dirname $0`
BASEDIR=`(cd "$BASEDIR"; pwd)`
MAIN_CLASS=${project.name}-${project.version}.jar

# If a specific java binary isn't specified search for the standard 'java' binary
if [ -z "$JAVACMD" ] ; then
  if [ -n "$JAVA_HOME"  ] ; then
      JAVACMD="$JAVA_HOME/bin/java"
  else
    JAVACMD=`which java`
  fi
fi


CLASSPATH="$BASEDIR"/config:
LOGDIR="$BASEDIR/logs"

echo "$CLASSPATH"

if [ ! -x "$JAVACMD" ] ; then
  echo "Error: JAVA_HOME is not defined correctly."
  echo "  We cannot execute $JAVACMD"
  exit 1
else
  echo "starting..."
fi

if [ -z "$OPTS_MEMORY" ] ; then
    OPTS_MEMORY="-server -Xms2048m -Xmx2048m -Xss512k -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m"
fi

nohup "$JAVACMD" $JAVA_OPTS \
  $OPTS_MEMORY \
  -classpath "$CLASSPATH" \
  -Dbasedir="$BASEDIR" \
  -Dfile.encoding="UTF-8" \
  -Djava.io.tmpdir=/var/tmp \
  -Djava.awt.headless="true" \
  -Dsun.net.client.defaultConnectTimeout="60000" \
  -Dsun.net.client.defaultReadTimeout="60000" \
  -Dnetworkaddress.cache.ttl="300" \
  -Dsun.net.inetaddr.ttl=300 \
  -XX:+HeapDumpOnOutOfMemoryError \
  -XX:HeapDumpPath="$LOGDIR/" \
  -XX:ErrorFile="$LOGDIR/java_error_%p.log" \
  -XX:+PrintGCDetails \
  -XX:+PrintGCDateStamps \
  -XX:+PrintGCTimeStamps \
  -Xloggc:"$LOGDIR/gc.log" \
  -jar $MAIN_CLASS \
  "$@" >>/dev/null 2>&1 &
