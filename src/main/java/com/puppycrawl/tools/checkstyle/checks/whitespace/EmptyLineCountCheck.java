package com.puppycrawl.tools.checkstyle.checks.whitespace;

import com.puppycrawl.tools.checkstyle.Utils;
import com.puppycrawl.tools.checkstyle.api.Check;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import org.apache.commons.beanutils.ConversionException;

import java.util.regex.Pattern;

/**
 * Created by jschneider on 7/1/15.
 */
public class EmptyLineCountCheck extends Check {

    /**
     * A key is pointing to the warning message text in "messages.properties"
     * file.
     */
    public static final String MSG_KEY = "maxEmptyLineCount";

    /** default maximum number of columns in a line */
    private static final int DEFAULT_MAX_EMPTY_LINES = 1;

    /** the maximum number of columns in a line */
    private int maxCount = DEFAULT_MAX_EMPTY_LINES;

    private int count;

    /** the regexp when long lines are ignored */
    private Pattern catchPattern;

    public EmptyLineCountCheck() {
        catchPattern = Pattern.compile("^\\s*$");
    }

    @Override
    public int[] getDefaultTokens() {
        return new int[0];
    }
    @Override
    public void beginTree(DetailAST rootAST) {
        final String[] lines = getLines();
        for (int i = 0; i < lines.length; i++) {

            final String line = lines[i];
            if (catchPattern.matcher(line).matches()) {
                count++;
            } else {
                if (count > maxCount) {
                    log((i + 1) - count, MSG_KEY, maxCount, count);
                }
                count = 0;
            }

        }
    }

    /**
     * @param count the maximum length of a line
     */
    public void setMaxCount(int count) {
        maxCount = count;
    }
}
