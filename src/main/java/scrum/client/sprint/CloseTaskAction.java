package scrum.client.sprint;

import scrum.client.img.Img;

import com.google.gwt.user.client.ui.Image;

public class CloseTaskAction extends GCloseTaskAction {

	public CloseTaskAction(Task task) {
		super(task);
	}

	@Override
	public String getLabel() {
		return "Close";
	}

	@Override
	public String getTooltip() {
		return "Mark task as done.";
	}

	@Override
	public boolean isExecutable() {
		return !task.isDone() && (!task.isOwnerSet() || task.isOwner(getCurrentUser()));
	}

	@Override
	protected void onExecute() {
		task.setDone(getCurrentUser());
	}

	@Override
	public Image getIcon() {
		return Img.bundle.done16().createImage();
	}

}
