package com.puppycrawl.tools.checkstyle;

import java.util.Random;

public class InputBracesSingleLineExitStatements
{
    public int test() {
        // Do nothing.
        return 0;
    }

    private int testIfElse() {
        // Test if solo with all exists,
        if (true) { // pass
            throw new RuntimeException();
        }
        if (true) throw new RuntimeException(); // pass
        if (true) // fail
            throw new RuntimeException();

        if (true) { //pass
            test();
        }
        if (true) return test(); //pass
        if (true) test(); //fail
        if (true) //fail
            test();

        for (;;) {
            if (true) { //pass
                break;
            }
            if (true) break; //pass
            if (true) //fail
                break;
            if (true) { //pass
                continue;
            }
            if (true) continue; //pass
            if (true) //fail
                continue;
        }

        if (true) { //pass
            return 0;
        }
        if (true) return 0; //pass
        if (true) //fail
            return 0;

        if (true) { //pass
            return 1;
        } else if (true) { //pass
            return 2;
        }
        if (true) { //pass
            return 1;
        } else if (true) //fail
            return 2;
        if (true) { //pass
            return 1;
        } else if (true) return 2; //fail
        if (true) //fail
            return 1;
        else if (true) { //pass
            return 2;
        }
        if (true) return 1; //fail
        else if (true) { //pass
            return 2;
        }
        if (true) return 1; //fail
        else if (true) return 2; //fail

        if (true) { //pass
            test();
        } else { //pass
            test();
        }

        if (true) { //pass
            test();
        } else //fail
            test();

        if (true) { //pass
            test();
        } else test(); //fail

        switch (new Random().nextInt()) {
            case 0:
                if (true) { //pass
                    test();
                } else { //pass
                    return 2;
                }
                break;
            case 1:
                if (true) { //pass
                    test();
                } else return 2; //fail
                break;
            case 2:
                if (true) { //pass
                    test();
                } else //fail
                    return 2;
                break;
            case 3:
                if (true) { //pass
                    test();
                } else //fail
                    return test();
                break;
            case 4:
                if (true) { //pass
                    test();
                } else { //pass
                    return test();
                }
                break;
            case 5:
                if (true) { //pass
                    test();
                } else return test(); //fail
                break;
        }
        return 3;
    }

    private void testDoWhile() {
        for (int i = 0; i < 10; i++) { //pass
            test();
        }
        for (int i = 0; i < 10; i++) test(); //fail
        int i = 0;
        while (i < 10) {
            i++; //pass
        }
        i = 0;
        while (i < 10) i++; //fail
        i = 0;
        do { //pass
            i++;
        } while (i < 20);
        i = 0;
        do i++; while (i < 20); //fail
    }
}
