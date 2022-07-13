#!/bin/bash
#
# Don't forget add this commands first!!!
# >> git config core.hookspath ".git/hooks"
# >> chmod +x .git/hooks/prepare-commit-msg

# Colors for console output
RED="\033[31m"
RESET="\033[39m"

# Check message template
commit_message=$(cat "$1")
commit_style="^((build|ci|docs|feat|fix|perf|refactor|style|test|chore|revert)(\(.+\))?: .{5,50})|Initial commit|initial commit|Init commit|init commit$"

if [[ ! "$commit_message" =~ $commit_style ]]; then
    echo -e "${RED}❌ Commit message does not follow the style convention!${RESET}" 1>&2
    echo
    exit 1
fi

# Return 0-exit code
echo "🎉 You are a rockstar..🔥🔥🔥"
echo
exit 0
