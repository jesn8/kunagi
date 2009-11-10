package scrum.client.risks;

import ilarkesto.gwt.client.AFieldValueWidget;
import ilarkesto.gwt.client.TableBuilder;
import ilarkesto.gwt.client.editor.DropdownEditorWidget;
import ilarkesto.gwt.client.editor.RichtextEditorWidget;
import ilarkesto.gwt.client.editor.TextEditorWidget;
import scrum.client.collaboration.CommentsWidget;
import scrum.client.common.AScrumWidget;
import scrum.client.common.FieldsWidget;

import com.google.gwt.user.client.ui.Widget;

public class RiskWidget extends AScrumWidget {

	private Risk risk;

	public RiskWidget(Risk risk) {
		super();
		this.risk = risk;
	}

	@Override
	protected Widget onInitialization() {
		FieldsWidget fields = new FieldsWidget();

		fields.add("Label", new TextEditorWidget(risk.getLabelModel()).switchToEditModeIfNull());
		fields.add("Description", new RichtextEditorWidget(risk.getDescriptionModel()));
		fields.add("Mitigation Plans", new RichtextEditorWidget(risk.getMitigationPlansModel()));
		fields.add("Impact", new DropdownEditorWidget<Integer>(risk.getImpactModel(),
				RiskComputer.IMPACT_LABEL_PROVIDER));
		fields.add("Probability", new DropdownEditorWidget<Integer>(risk.getProbabilityModel(),
				RiskComputer.PROBABILITY_LABEL_PROVIDER));
		fields.add("Priority", new AFieldValueWidget() {

			@Override
			protected void onUpdate() {
				setText(risk.getPriorityLabel());
			}
		});

		return TableBuilder.row(20, fields, new CommentsWidget(risk));
	}

}
