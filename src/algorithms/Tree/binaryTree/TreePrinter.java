package algorithms.tree.binaryTree;
/**
 * @author Saiteja Tokala
 * Adapted By Youcheng Ye
 */
import java.util.ArrayList;
import java.util.List;


/**
 * Binary algorithms.tree printer
 *
 * @author saiteja
 */
public class TreePrinter
{
    /**
     * Print a algorithms.tree
     *
     * @param root
     *            algorithms.tree root node
     */
    public static String toString(TreeNode root)
    {
        String result = "";
        List<List<String>> lines = new ArrayList<List<String>>();

        List<TreeNode> level = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (TreeNode n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = new Integer(n.key).toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<TreeNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    result += c;

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            result += " ";
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            result += (j % 2 == 0 ? " " : "─");
                        }
                        result += (j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            result += (j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                result += "\n";
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    result += " ";
                }
                result += f;
                for (int k = 0; k < gap2; k++) {
                    result += " ";
                }
            }
            result += "\n";

            perpiece /= 2;
        }
        return result;
    }
}
