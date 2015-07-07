////////////////////////////////////////////////////////////////////////////////
// checkstyle: Checks Java source code for adherence to a set of rules.
// Copyright (C) 2001-2015 the original author or authors.
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this library; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
////////////////////////////////////////////////////////////////////////////////

package com.puppycrawl.tools.checkstyle.checks.whitespace;

import com.puppycrawl.tools.checkstyle.BaseCheckTestSupport;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import org.junit.Test;

import static com.puppycrawl.tools.checkstyle.checks.whitespace.EmptyLineCountCheck.MSG_KEY;

public class EmptyLineCountCheckTest extends BaseCheckTestSupport {

    @Test
    public void testSimple()
        throws Exception {
        final DefaultConfiguration checkConfig =
            createCheckConfig(EmptyLineCountCheck.class);
        final String[] expected = {
            "38: " + getCheckMessage(MSG_KEY, 1, 2),
            "41: " + getCheckMessage(MSG_KEY, 1, 3),
            "45: " + getCheckMessage(MSG_KEY, 1, 2),
            "50: " + getCheckMessage(MSG_KEY, 1, 2),
            "53: " + getCheckMessage(MSG_KEY, 1, 3),
            "57: " + getCheckMessage(MSG_KEY, 1, 2),
            "62: " + getCheckMessage(MSG_KEY, 1, 3),
        };
        verify(checkConfig, getPath("InputSimpleEmptyLine.java"), expected);
    }

    @Test
    public void shouldLogActualEmptyLineCount()
        throws Exception {
        final DefaultConfiguration checkConfig =
            createCheckConfig(EmptyLineCountCheck.class);
        checkConfig.addAttribute("maxCount", "2");
        final String[] expected = {
                "41: " + getCheckMessage(MSG_KEY, 2, 3),
                "53: " + getCheckMessage(MSG_KEY, 2, 3),
                "62: " + getCheckMessage(MSG_KEY, 2, 3),
        };
        verify(checkConfig, getPath("InputSimpleEmptyLine.java"), expected);
    }
}
