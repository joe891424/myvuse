package com.qualtrics.digital;

/* JADX INFO: compiled from: InterceptJsonClasses.java */
/* JADX INFO: loaded from: classes6.dex */
class TreeNode {
    String Comparator;
    String Expression;
    TreeNode Left;
    String LogicType;
    String Operator;
    TreeNode Right;
    String Type;
    Object Value;

    TreeNode() {
    }

    public boolean evaluate() {
        TreeNode treeNode;
        String str = this.Type;
        str.hashCode();
        switch (str) {
            case "ComparatorNode":
                String str2 = this.Comparator;
                if (str2 == null) {
                    QualtricsLog.logError("Evaluate function called on node with null comparator");
                    return false;
                }
                TreeNode treeNode2 = this.Left;
                String str3 = treeNode2.LogicType;
                String str4 = treeNode2.Expression;
                Object obj = null;
                if ((this.Value instanceof Boolean) || ((treeNode = this.Right) != null && (treeNode.Value instanceof Boolean))) {
                    TreeNode treeNode3 = this.Right;
                    if (treeNode3 != null) {
                        obj = (Boolean) treeNode3.Value;
                    }
                } else if (treeNode != null) {
                    obj = (String) treeNode.Value;
                }
                return ComparatorNode.evaluate(str3, str4, obj, str2);
            case "ConjunctionNode":
                TreeNode treeNode4 = this.Left;
                boolean z = treeNode4 != null && treeNode4.evaluate();
                TreeNode treeNode5 = this.Right;
                boolean z2 = treeNode5 != null && treeNode5.evaluate();
                String str5 = this.Operator;
                str5.hashCode();
                if (str5.equals("OR")) {
                    return z || z2;
                }
                if (str5.equals("AND")) {
                    return z && z2;
                }
                return false;
            case "ValueNode":
                Object obj2 = this.Value;
                if (obj2 instanceof Boolean) {
                    return ((Boolean) obj2).booleanValue();
                }
            case "LogicNode":
                return false;
            default:
                QualtricsLog.logError("Evaluate function called on node with invalid type during logic tree evaluation");
                return false;
        }
    }
}
