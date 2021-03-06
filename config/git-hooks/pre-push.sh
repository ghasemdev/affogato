#!/bin/bash
#
# Don't forget add this commands first!!!
# >> git config core.hookspath ".git/hooks"
# >> chmod +x .git/hooks/pre-push

# Colors for console output
RED="\033[31m"
GREEN="\033[32m"
CYAN="\033[36m"
RESET="\033[39m"

# Run unit test
echo
echo -e "${CYAN}Running Unit Tests... ๐งช๐งช๐งช${RESET}"
./gradlew test
TEST_EXIT_CODE=$?
if [[ "$TEST_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}โ Unit Test all good.${RESET}"
else
    echo -e "${RED}โ Please you can do better than this..๐${RESET}" 1>&2
    exit 1
fi
echo
echo

# Run instrumentation test
echo
echo -e "${CYAN}Running Instrumentation Tests... ๐งช๐งช๐งช${RESET}"
./gradlew connectedAndroidTest
UI_TEST_EXIT_CODE=$?
if [[ "$UI_TEST_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}โ Instrumentation Test all good.${RESET}"
else
    echo -e "${RED}โ Please you can do better than this..๐${RESET}" 1>&2
    exit 1
fi
echo
echo

# Run kover verify
echo -e "${CYAN}Running Test Coverage... โ๏ธโ๏ธโ๏ธ${RESET}"
./gradlew koverMergedVerify
KOVER_EXIT_CODE=$?
if [[ "$KOVER_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}โ Test coverage is excellent.${RESET}"
else
    echo -e "${RED}โ Please write more tests to get the minimum coverage percentage.${RESET}" 1>&2
    exit 1
fi
echo
echo

# Run kover report
echo -e "${CYAN}Generate Test Coverage Report... ๐๐๐${RESET}"
./gradlew koverMergedReport
KOVER_REPORT_EXIT_CODE=$?
if [[ "$KOVER_REPORT_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}โ Test coverage generated.${RESET}"
else
    echo -e "${RED}โ There is a problem.${RESET}" 1>&2
    exit 1
fi
echo
echo

# Run dokka
echo -e "${CYAN}Generate Documentation... ๐๐๐${RESET}"
./gradlew dokkaHtmlMultiModule
DOKKA_EXIT_CODE=$?
if [[ "$DOKKA_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}โ Document generated.${RESET}"
else
    echo -e "${RED}โ There is a problem.${RESET}" 1>&2
    exit 1
fi
echo
echo

# return 0-exit code
echo "You are a senior..๐"
echo
exit 0
