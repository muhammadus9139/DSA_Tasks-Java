

//SP25-BCS-151
public class HTMLValidator {

    private String extracttag(String tag) {

        String name = tag.replace("<", "").replace("/", "").trim();
        return name.toLowerCase();
    }

    private boolean isClosingttag(String tag) {
        return tag.startsWith("</");
    }

    private boolean isOpeningtag(String tag) {
        return tag.startsWith("<") && !tag.startsWith("</");
    }

    public String validate(String html) {
        TagStack stack = new TagStack(10);

        int i = 0;
        while (i < html.length()) {
            if (html.charAt(i) == '<') {
                int j = html.indexOf('>', i);
                if (j == -1) {
                    return "invalid";
                }
                String tag = html.substring(i, j + 1);

                if (isClosingttag(tag)) {
                    String tagname = extracttag(tag);

                    if (stack.isempty()) {
                        return "Invalid Closing tag ";
                    }
                    String top = stack.pop();
                    if (!top.equals(tagname)) {
                        return "Invalid Tag mismatch";
                    }
                } else if (isOpeningtag(tag)) {
                    String tagname = extracttag(tag);
                    stack.push(tagname);
                }
                i = j + 1;
            } else {
                i++;
            }
        }
        if (!stack.isempty()) {
            return "Invalid Unclosed tag";
        }
        return "valid";
    }
}
