package com.bolivarSoftware.eTurnos.beans;

import com.bolivarSoftware.eTurnos.domain.Turno;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by Fede Beron on 16/1/2018.
 */
public class ContentExcelView extends AbstractXlsxView {

    private static final DateFormat DATE_FORMAT = DateFormat.getDateTimeInstance (DateFormat.SHORT, DateFormat.SHORT);

    @Override
    protected void buildExcelDocument(Map<String, Object> model, org.apache.poi.ss.usermodel.Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"reporte-turnos.xlsx\"");

        @SuppressWarnings("unchecked")
        List<Turno> turnos = (List<Turno>) model.get("turnos");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Reporte de Turnos");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Cod. Int");
        header.createCell(1).setCellValue("Nro");
        header.createCell(2).setCellValue("Fecha Solicitado");
        header.createCell(3).setCellValue("Fecha Llamado");
        header.createCell(4).setCellValue("Estado");
        header.createCell(5).setCellValue("Socio");
        header.createCell(6).setCellValue("Puesto");

        // Create data cells
        int rowCount = 1;
        for (Turno turno : turnos) {
            Row courseRow = sheet.createRow(rowCount++);
            courseRow.createCell(0).setCellValue(turno.getId());
            courseRow.createCell(1).setCellValue(turno.getNumeroTicket());
            courseRow.createCell(2).setCellValue(turno.getFechaSolicitado() != null ?  DATE_FORMAT.format(turno.getFechaSolicitado()) : "");
            courseRow.createCell(3).setCellValue(turno.getFechaLlamado() != null ?  DATE_FORMAT.format(turno.getFechaLlamado()) : "");
            courseRow.createCell(4).setCellValue(turno.getEstado().getDescripcion());
            courseRow.createCell(5).setCellValue(turno.getCliente() != null ? turno.getCliente().toString() :  "");
            courseRow.createCell(6).setCellValue(turno.getPuesto() != null ? turno.getPuesto().toString() : "");
        }
    }
}

