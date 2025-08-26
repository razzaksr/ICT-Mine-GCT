package org.hostpital.extension.listener;

import org.hibernate.event.spi.*;

import java.util.logging.Logger;


public class VehicleExtensionListener implements PostInsertEventListener, PostUpdateEventListener, PostDeleteEventListener {
    Logger logger = Logger.getLogger(VehicleExtensionListener.class.getName());
    @Override
    public void onPostDelete(PostDeleteEvent postDeleteEvent) {
        logger.info(postDeleteEvent.toString()+" deleted");
    }

    @Override
    public void onPostInsert(PostInsertEvent postInsertEvent) {
        logger.info(postInsertEvent.toString()+" inserted");
    }

    @Override
    public void onPostUpdate(PostUpdateEvent postUpdateEvent) {
        logger.info(postUpdateEvent.toString()+" updated");
    }
}
