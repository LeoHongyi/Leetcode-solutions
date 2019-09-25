package algorithms.tree.knaryTree;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Qihao He
 * @date 09/24/2019
 */
public class KnaryTreeNode {
      int key;
      List<KnaryTreeNode> children;
      public KnaryTreeNode(int key) {
          this.key = key;
          this.children = new ArrayList<>();
      }
}