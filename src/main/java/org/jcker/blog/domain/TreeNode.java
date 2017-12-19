package org.jcker.blog.domain;

import org.jcker.utils.BaseEntity;

import java.util.List;

/**
 * Created by <a href='http://jcker.org'>Alan Turing</a>
 * on 2017-11-06 at 6:33 PM
 *
 * @version 1.0
 */
public class TreeNode extends BaseEntity {
    String name;
    boolean open;
    List<TreeNode> children;
    String url;
    String click;
    String level;
    String tId;
    String parentTId;
    String isParent;
    String zAsync;
    String isFirstNode;
    String isLastNode;
    String isAjaxing;
    String checked;
    String checkedOld;
    String nocheck;
    String chkDisabled;
    String halfCheck;
    String check_Child_State;
    String check_Focus;
    String isHover;
    String editNameFlag;
    String target;


    public TreeNode(String name) {
        this.name = name;
    }

    public TreeNode() {
    }

    public TreeNode(String name, String url) {
        this.url = url;
        this.name = name;
        this.target = "_self";
    }

    public TreeNode(String name,String url, boolean open, List<TreeNode> children) {
        this.name = name;
        this.url = url;
        this.open = open;
        this.children = children;
    }

    public TreeNode(String name, boolean open, List<TreeNode> children, String url, String click, String level, String tId, String parentTId, String isParent, String zAsync, String isFirstNode, String isLastNode, String isAjaxing, String checked, String checkedOld, String nocheck, String chkDisabled, String halfCheck, String check_Child_State, String check_Focus, String isHover, String editNameFlag) {
        this.name = name;
        this.open = open;
        this.children = children;
        this.url = url;
        this.click = click;
        this.level = level;
        this.tId = tId;
        this.parentTId = parentTId;
        this.isParent = isParent;
        this.zAsync = zAsync;
        this.isFirstNode = isFirstNode;
        this.isLastNode = isLastNode;
        this.isAjaxing = isAjaxing;
        this.checked = checked;
        this.checkedOld = checkedOld;
        this.nocheck = nocheck;
        this.chkDisabled = chkDisabled;
        this.halfCheck = halfCheck;
        this.check_Child_State = check_Child_State;
        this.check_Focus = check_Focus;
        this.isHover = isHover;
        this.editNameFlag = editNameFlag;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getParentTId() {
        return parentTId;
    }

    public void setParentTId(String parentTId) {
        this.parentTId = parentTId;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public String getzAsync() {
        return zAsync;
    }

    public void setzAsync(String zAsync) {
        this.zAsync = zAsync;
    }

    public String getIsFirstNode() {
        return isFirstNode;
    }

    public void setIsFirstNode(String isFirstNode) {
        this.isFirstNode = isFirstNode;
    }

    public String getIsLastNode() {
        return isLastNode;
    }

    public void setIsLastNode(String isLastNode) {
        this.isLastNode = isLastNode;
    }

    public String getIsAjaxing() {
        return isAjaxing;
    }

    public void setIsAjaxing(String isAjaxing) {
        this.isAjaxing = isAjaxing;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getCheckedOld() {
        return checkedOld;
    }

    public void setCheckedOld(String checkedOld) {
        this.checkedOld = checkedOld;
    }

    public String getNocheck() {
        return nocheck;
    }

    public void setNocheck(String nocheck) {
        this.nocheck = nocheck;
    }

    public String getChkDisabled() {
        return chkDisabled;
    }

    public void setChkDisabled(String chkDisabled) {
        this.chkDisabled = chkDisabled;
    }

    public String getHalfCheck() {
        return halfCheck;
    }

    public void setHalfCheck(String halfCheck) {
        this.halfCheck = halfCheck;
    }

    public String getCheck_Child_State() {
        return check_Child_State;
    }

    public void setCheck_Child_State(String check_Child_State) {
        this.check_Child_State = check_Child_State;
    }

    public String getCheck_Focus() {
        return check_Focus;
    }

    public void setCheck_Focus(String check_Focus) {
        this.check_Focus = check_Focus;
    }

    public String getIsHover() {
        return isHover;
    }

    public void setIsHover(String isHover) {
        this.isHover = isHover;
    }

    public String getEditNameFlag() {
        return editNameFlag;
    }

    public void setEditNameFlag(String editNameFlag) {
        this.editNameFlag = editNameFlag;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

}
