package org.inno.control;

/**
 *
 * @author spindizzy
 */
abstract class AbstractController {
    private final Context context = Context.Instance;

    protected Context getContext() {
        return context;
    }
    
}
