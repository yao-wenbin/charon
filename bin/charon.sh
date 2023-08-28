#bin/sh
PARENT_DIR=$(cd $(dirname $0);cd ..; pwd)

SPRING_ARG="--spring.config.additional-location=file:${PARENT_DIR}/config/charon.yml"

java -jar ${PARENT_DIR}/charon-0.0.1-SNAPHOST.jar ${SPRING_ARG}