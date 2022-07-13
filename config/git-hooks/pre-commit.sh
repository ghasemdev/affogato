#!/bin/bash
#
# Don't forget add this commands first!!!
# >> git config core.hookspath ".git/hooks"
# >> chmod +x .git/hooks/pre-commit

# Colors for console output
RED="\033[31m"
GREEN="\033[32m"
CYAN="\033[36m"
RESET="\033[39m"

# Run detekt
echo -e "${CYAN}Running static analysis and linter ... 🔎🔎🔎${RESET}"
./gradlew detekt
ANALYSIS_EXIT_CODE=$?
if [[ "$ANALYSIS_EXIT_CODE" == 0 ]]; then
    echo -e "${GREEN}✅ Detekt found no problems.${RESET}"
else
    echo -e "${RED}❌ Detekt found violations it could not fix, Please try again. 😭${RESET}" 1>&2
    exit 1
fi
echo
echo

# return 0-exit code
exit 0
