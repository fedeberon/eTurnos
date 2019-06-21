USE [soccam]
GO

/****** Object:  Table [dbo].[microcreditos]    Script Date: 12/06/2019 04:54:09 p.m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[microcreditos](
	[microcreditos_id] [bigint] IDENTITY(1,1) NOT NULL,
	[microcreditos_modo] [char](1) NULL,
	[microcreditos_tipoSocio] [char](1) NULL,
	[microcreditos_socio] [bigint] NOT NULL,
	[microcreditos_monto] [decimal](25, 13) NULL,
	[microcreditos_gastosAdministrativos] [decimal](25, 13) NULL,
	[microcreditos_cuotas] [int] NULL,
	[microcreditos_interes] [decimal](5, 2) NULL,
	[microcreditos_porcentajeMora] [decimal](5, 2) NULL,
	[microcreditos_periodicidad] [int] NULL,
	[microcreditos_primerVencimiento] [date] NULL,
	[microcreditos_estado] [char](1) NULL,
	[microcreditos_montoCuotaBonificada] [decimal](25, 13) NULL,
	[microcreditos_totalPagar] [decimal](25, 13) NULL,
	[microcreditos_deleted] [bit] NULL,
	[microcreditos_modificado] [datetime] NULL,
	[microcreditos_cheque] [nvarchar](max) NULL CONSTRAINT [DF_microcreditos_microcreditos_cheques]  DEFAULT (''),
 CONSTRAINT [PK_microcreditos] PRIMARY KEY CLUSTERED 
(
	[microcreditos_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


