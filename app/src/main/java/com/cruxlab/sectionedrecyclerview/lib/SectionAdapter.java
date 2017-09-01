package com.cruxlab.sectionedrecyclerview.lib;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public abstract class SectionAdapter<VH extends RecyclerView.ViewHolder> {

    private SectionItemManager itemManager;

    int section;

    public abstract int getItemCount();

    public abstract VH onCreateViewHolder(ViewGroup parent);

    public abstract void onBindViewHolder(VH holder, int position);

    public abstract VH onCreateHeaderViewHolder(ViewGroup parent);

    public abstract void onBindHeaderViewHolder(VH holder);

    public final void notifyItemInserted(int pos) {
        Checker.checkItemManager(itemManager);
        Checker.checkPosition(pos, getItemCount() + 1);
        itemManager.notifyInserted(section, pos);
    }

    public final void notifyItemInserted(int... posList) {
        for (int pos : posList) {
            notifyItemInserted(pos);
        }
    }

    public final void notifyItemInserted(List<Integer> posList) {
        for (int pos : posList) {
            notifyItemInserted(pos);
        }
    }

    public final void notifyItemRangeInserted(int startPos, int cnt) {
        Checker.checkItemManager(itemManager);
        Checker.checkPosRange(startPos, cnt, getItemCount());
        itemManager.notifyRangeInserted(section, startPos, cnt);
    }

    public final void notifyItemRemoved(int pos) {
        Checker.checkItemManager(itemManager);
        Checker.checkPosition(pos, getItemCount());
        itemManager.notifyRemoved(section, pos);
    }

    public final void notifyItemRemoved(int... posList) {
        for (int pos : posList) {
            notifyItemRemoved(pos);
        }
    }

    public final void notifyItemRemoved(List<Integer> posList) {
        for (int pos : posList) {
            notifyItemRemoved(pos);
        }
    }

    public final void notifyItemRangeRemoved(int startPos, int cnt) {
        Checker.checkItemManager(itemManager);
        Checker.checkPosRange(startPos, cnt, getItemCount());
        itemManager.notifyRangeRemoved(section, startPos, cnt);
    }

    public final void notifyItemChanged(int pos) {
        Checker.checkItemManager(itemManager);
        Checker.checkPosition(pos, getItemCount());
        itemManager.notifyChanged(section, pos);
    }

    public final void notifyItemChanged(int... posList) {
        for (int pos : posList) {
            notifyItemChanged(pos);
        }
    }

    public final void notifyItemChanged(List<Integer> posList) {
        for (int pos : posList) {
            notifyItemChanged(pos);
        }
    }

    public final void notifyItemRangeChanged(int startPos, int cnt) {
        Checker.checkItemManager(itemManager);
        Checker.checkPosRange(startPos, cnt, getItemCount());
        itemManager.notifyRangeChanged(section, startPos, cnt);
    }

    public final void notifySectionChanged() {
        Checker.checkItemManager(itemManager);
        itemManager.notifyChanged(section);
    }

    public final void notifyItemMoved(int fromPos, int toPos) {
        Checker.checkItemManager(itemManager);
        Checker.checkPosition(fromPos, getItemCount());
        Checker.checkPosition(toPos, getItemCount());
        itemManager.notifyMoved(section, fromPos, toPos);
    }

    public final void notifyHeaderChanged() {
        Checker.checkItemManager(itemManager);
        itemManager.notifyHeaderChanged(section);
    }

    void setItemManager(SectionItemManager itemManager) {
        this.itemManager = itemManager;
    }

}