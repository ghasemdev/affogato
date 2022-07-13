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
echo -e "${CYAN}Running Unit Tests... 🧪🧪🧪${RESET}"
./gradlew test
TEST_EXIT_CODE=$?
if [[ "$TEST_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}✅ Unit Test all good.${RESET}"
else
    echo -e "${RED}❌ Please you can do better than this..😐${RESET}" 1>&2
    exit 1
fi
echo
echo

# Run instrumentation test
echo
echo -e "${CYAN}Running Instrumentation Tests... 🧪🧪🧪${RESET}"
./gradlew connectedAndroidTest
UI_TEST_EXIT_CODE=$?
if [[ "$UI_TEST_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}✅ Instrumentation Test all good.${RESET}"
else
    echo -e "${RED}❌ Please you can do better than this..😐${RESET}" 1>&2
    exit 1
fi
echo
echo

# Run kover verify
echo -e "${CYAN}Running Test Coverage... ⚗️⚗️⚗️${RESET}"
./gradlew koverMergedVerify
KOVER_EXIT_CODE=$?
if [[ "$KOVER_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}✅ Test coverage is excellent.${RESET}"
else
    echo -e "${RED}❌ Please write more tests to get the minimum coverage percentage.${RESET}" 1>&2
    exit 1
fi
echo
echo

# Run kover report
echo -e "${CYAN}Generate Test Coverage Report... 📊📊📊${RESET}"
./gradlew koverMergedReport
KOVER_REPORT_EXIT_CODE=$?
if [[ "$KOVER_REPORT_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}✅ Test coverage generated.${RESET}"
else
    echo -e "${RED}❌ There is a problem.${RESET}" 1>&2
    exit 1
fi
echo
echo

# Run dokka
echo -e "${CYAN}Generate Documentation... 📝📝📝${RESET}"
./gradlew dokkaHtmlMultiModule
DOKKA_EXIT_CODE=$?
if [[ "$DOKKA_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}✅ Document generated.${RESET}"
else
    echo -e "${RED}❌ There is a problem.${RESET}" 1>&2
    exit 1
fi
echo
echo

# return 0-exit code
echo "You are a senior..😎"
echo
exit 0
