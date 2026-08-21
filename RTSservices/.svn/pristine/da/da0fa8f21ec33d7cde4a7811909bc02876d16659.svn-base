CREATE INDEX "ward_id_idx" ON "node_master" USING btree ("ward_id");

CREATE INDEX "city_idx" ON "city" USING btree ("taluka_id");

CREATE INDEX "district_idx" ON "district" USING btree ("state_id");

CREATE INDEX "plot_idx" ON "plot" USING btree ("plot_type_id");

CREATE INDEX "taluka_idx" ON "taluka" USING btree ("district_id");

CREATE INDEX "ward_idx" ON "ward" USING btree ("city_id");

CREATE INDEX "ward_sector_idx" ON "ward_sector" USING btree ("sector_id", "ward_id");