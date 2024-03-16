package org.ritesh.rollout;

import org.ritesh.model.AppVersionDetails;

public interface RolloutStrategy {
    void rollout(AppVersionDetails appVersionDetails);
}