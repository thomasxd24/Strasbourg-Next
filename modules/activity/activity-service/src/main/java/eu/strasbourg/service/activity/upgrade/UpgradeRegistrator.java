package eu.strasbourg.service.activity.upgrade;

import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import eu.strasbourg.service.activity.upgrade.v1_1_0.UpgradeSchema;
import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = {UpgradeRegistrator.class, UpgradeStepRegistrator.class})
public class UpgradeRegistrator implements UpgradeStepRegistrator {

    @Override
    public void register(Registry registry) {

        registry.register( "1.0.0", "1.1.0",
                new UpgradeSchema());
    }
}