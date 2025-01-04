package vr.projects.sunnycompass.berrytracker;

import java.util.List;

/** Interface for managing berry categories in the system. */
public interface CategoryApi {

    /**
     * Creates a new <b>berry category</b>.
     *
     * @param name the name of the category, e.g., 'Entertainment' or 'Salary'
     * @param type the type of the category, either 'SINK' (expense) or 'SOURCE' (income)
     * @param tags a list of tags associated with the category for additional categorization, e.g., ["flex", "fixed"]
     * @return a {@link CategoryResource} object representing the created category, including its unique identifier
     */
    public CategoryResource create(String name, String type, List<String> tags);
}
